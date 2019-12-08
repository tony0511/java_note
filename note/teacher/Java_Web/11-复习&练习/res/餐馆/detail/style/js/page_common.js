// JavaScript Document



/**
 * 删除前的确认提示
 */
function delConfirm(){
	return window.confirm("您确定要删除一条记录码？");	
}



/**
 * （使用模式对活框）显示图片
 */ 
function showImage( url, width, height ){
	var sFeatures = "resizable: yes; ";
	if( width != null ){
		sFeatures += "dialogWidth:" + width + "px; ";
	}
	if( height != null ){
		sFeatures += "dialogHeight:" + height + "px; ";
	}
	window.showModalDialog(url, null, sFeatures);
}

