/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.language =  "zh-cn" ; 
	config.image_previewText = ' ';

	config.filebrowserBrowseUrl =  '/CkeditorUploadDownload/ckfinder/ckfinder.html' ;  
    config.filebrowserImageBrowseUrl =  '/CkeditorUploadDownload/ckfinder/ckfinder.html?type=Images' ;  
    config.filebrowserFlashBrowseUrl =  '/CkeditorUploadDownload/ckfinder/ckfinder.html?type=Flash' ;  
    config.filebrowserUploadUrl =  '/CkeditorUploadDownload/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files' ;  
    config.filebrowserImageUploadUrl =  '/CkeditorUploadDownload/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images' ;  
    config.filebrowserFlashUploadUrl =  '/CkeditorUploadDownload/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash' ;  
    config.filebrowserWindowWidth = '1000';  
    config.filebrowserWindowHeight = '700';  
};
