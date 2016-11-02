DELIMITER $$

CREATE PROCEDURE `seckill`.`seckill_procedure`
(
	IN v_seckill_id bigint, IN v_user_phone bigint, IN v_kill_time datetime, OUT v_state int
)

BEGIN
	DECLARE insert_count int default 0;
	START TRANSACTION;
	INSERT ignore INTO success_seckill(seckill_id, user_phone, create_time) values (v_seckill_id, v_user_phone, v_kill_time);
	SELECT row_count() INTO insert_count;
	IF  (insert_count = 0 )  THEN
	ROLLBACK;
	SET v_state = -1;
	ELSEIF ( insert_count < 0 )  THEN
	ROLLBACK;
	SET v_state = -2;
	ELSE
		UPDATE seckill SET number = number - 1 WHERE seckill_id = v_seckill_id AND v_kill_time <= end_time AND v_kill_time >= start_time;
		SELECT row_count() INTO insert_count;
		IF(insert_count = 0) THEN
		ROLLBACK;
		SET v_state = -1;
		ELSEIF(insert_count < 0) THEN
		ROLLBACK;
		SET v_state = -2;
		ELSE
		COMMIT;
		SET v_state = 1;
		END IF;
	END IF;
END;
$$

DELIMITER ;

SET @state = -3;

CALL seckill_procedure(1001,11111111111,NOW(),@state);


select @state;
