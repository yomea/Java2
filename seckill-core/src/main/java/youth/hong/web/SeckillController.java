package youth.hong.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import youth.hong.dto.Exposer;
import youth.hong.dto.SeckillExcution;
import youth.hong.dto.SeckillResult;
import youth.hong.entity.Seckill;
import youth.hong.enums.SeckillStateEnum;
import youth.hong.exception.RepeatSecKillException;
import youth.hong.exception.SecKillOverException;
import youth.hong.service.SeckillService;

@Controller
@RequestMapping(value = "/seckill", method = RequestMethod.GET)
public class SeckillController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Seckill> seckills = seckillService.getSeckillList();
		model.addAttribute("list", seckills);
		return "list";
	}

	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
		// 判断是否传了值
		if (seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		// 判断当前seckillId是否存在商品
		if (seckill == null) {
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
		SeckillResult<Exposer> result = null;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			logger.error(e.getMessage());
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	@ResponseBody
	public SeckillResult<SeckillExcution> execute(@PathVariable("seckillId") Long seckillId,
			@PathVariable("md5") String md5, @CookieValue(value = "killPhone", required = false) Long phone) {
		SeckillResult<SeckillExcution> result = null;
		// 用户未注册
		if (phone == null) {
			return result = new SeckillResult<SeckillExcution>(false, "未注册");
		}
		try {
			/*SeckillExcution seckillExcution = seckillService.executeSeckill(seckillId, phone, md5);*/
			SeckillExcution seckillExcution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			result = new SeckillResult<SeckillExcution>(true, seckillExcution);
		} catch (RepeatSecKillException e) {
			result = new SeckillResult<SeckillExcution>(true,
					new SeckillExcution(seckillId, SeckillStateEnum.REPEAT_KILL));
		} catch (SecKillOverException e) {
			result = new SeckillResult<SeckillExcution>(true, new SeckillExcution(seckillId, SeckillStateEnum.END));
		} catch (Exception e) {
			result = new SeckillResult<SeckillExcution>(true,
					new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR));
		}
		return result;
	}

	@RequestMapping(value = "/time/now", method = RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public SeckillResult<Long> time() {
		Date date = new Date();
		return new SeckillResult<Long>(true, date.getTime());
	}

}
