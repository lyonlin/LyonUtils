/**
 * JS工具
 * @author Lyon
 **/
var util = new Util(); 

function Util(){	
	/** 
	 * 是否為空值或空字串: util.isEmpty(val)
	 */
	this.isEmpty = function(val)
	{
		if( val===undefined || !String(val).trim() ){
			return true;
		}
		else{
			return false;
		}
	};	
	/** 
	 * 空值轉空字串: util.nullToEmpty(val)
	 */
	this.nullToEmpty = function(val)
	{
		if(util.isEmpty(val)){
			return "";
		}
		else{
			return val;
		}
	};	
	/** 
	 * 空字串轉空值: util.emptyToNull(val)
	 */
	this.emptyToNull = function(val)
	{
		if(util.isEmpty(val)){
			return null;
		}
		else{
			return val;
		}
	};
	/** 
	 * 字串轉整數: util.toInt(val)
	 */
	this.toInt = function(val)
	{
		var intVal = parseInt(val);
		if(intVal){
			return intVal;
		}
		return 0;		
	};
};
