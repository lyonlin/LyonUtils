/**
 * 系統物件初始化
 * @author Lyon
 **/
var system = new Object();

function initSystem(){ 
	
	/** 
	 * 解析度寬度: system.screenWidth
	 */
	try{
		if(screen.width>2000)
			system.screenWidth = screen.width/2;
		else
			system.screenWidth = screen.width;
		if(sys.screenWidth<1024)
			system.screenWidth = 1024;
	}
	catch(err){
		system.screenWidth=1024;
	}
	
	/** 
	 * 解析度高度: system.screenHeight
	 */
	system.screenHeight = screen.height;
	
	/** 
	 * 子頁面寬度: system.pageWidth
	 */
	system.pageWidth = 1000;//sys.screenWidth-225;
	
	/** 
	 * 子頁面高度: system.pageHeight
	 */
	try{	
		system.pageHeight = screen.height-360;
		if(system.pageHeight<370)
			system.pageHeight = 370;	
	}
	catch(err){
		system.pageHeight = 370;
	}
	
	/** 
	 * 記錄: system.log(string)
	 */
	system.log = function(message){
		try{
			console.log(message);
		}catch(err){
			alert(message);
		}
	};
	
}; 
initSystem();
var sys = system;