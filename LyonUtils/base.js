//$.ajaxSetup({
	//async: false
//});

$.fn.datebox.defaults.height = 26;

$.fn.datebox.defaults.formatter = function(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'/'+m+'/'+d;
};

$.fn.datebox.defaults.parser = function(s){	
	var sf = s.replace( /(\d{4})\/(\d{2})\/(\d{2})/, "$2/$3/$1");
	var t = Date.parse(sf);
	if (!isNaN(t)){
		return new Date(t);
	} else {
		return new Date();
	}
};

//$.fn.panel.defaults.openAnimation = 'show';

$.extend($.fn.datagrid.defaults.editors, {
    numberspinner: {
        init: function(container, options){
            var input = $('<input type="text">').appendTo(container);
            return input.numberspinner(options);
        },
        destroy: function(target){
            $(target).numberspinner('destroy');
        },
        getValue: function(target){
            return $(target).numberspinner('getValue');
        },
        setValue: function(target, value){
            $(target).numberspinner('setValue',value);
        },
        resize: function(target, width){
            $(target).numberspinner('resize',width);
        }
    }
});

/* 民國
 * formatter:function(date) {
        var y = date.getFullYear()-1911;
        var m = date.getMonth()+1;
        var d = date.getDate();

        return y+'/'+(m<10?('0'+m):m)+'/'+(d<10?('0'+d):d);
    },
    parser:function(s){
        if (!s) return new Date();
        var ss = (s.split('/'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y+1911,m-1,d);
        } else {
            return new Date();
        }
    }  
 * 
 */

/** 訊息顯示 **/
function showMessage(message){
	$.blockUI({ 
		message: "<div id='blockMsg' style='height: 20px'><img src='Resource/css/icons/info.png'/>"+message+"</div>",
		timeout: 1000,
		css: { 		
			padding: '8px 8px 5px 0px', 
			backgroundColor: '#FFFFFF', 
			'-webkit-border-radius': '10px', 
			'-moz-border-radius': '10px', 
			opacity: .8
		}
	});
};

/** 網頁遮蔽 **/
function showBlock(message){
	$.blockUI({ 
		message: "<div id='blockMsg' style='height: 20px'><img src='Resource/images/busy.gif'/>"+message+"</div>",
		css: { 		
			padding: '8px 8px 5px 0px', 
			backgroundColor: '#FFFFFF', 
			'-webkit-border-radius': '10px', 
			'-moz-border-radius': '10px', 
			opacity: .8
		}
	});
}

/** 遮蔽解除 **/
function hideBlock(message, isOk, callback){
	if(message)
	{
		var imgName = "ok";
		if( isOk!=undefined && isOk==false )
			imgName = "cancel";
		$("#blockMsg").html("<img src='Resource/css/icons/"+imgName+".png'/>"+message);
		setTimeout(function(){
			$.unblockUI();
			if( callback!=null && callback!=undefined ){
				callback();
			}
		}, 1000);
	}
	else
	{
		$.unblockUI();
	}
}

/** 
 * 字串是否為空(Empty)
 */
function isEmpty(value)
{
	if(jQuery.trim(value)){
		return false;
	}
	else{
		return true;
	}
}

/**
 * isEmpty時，回傳空值
 */
function nullToEmpty(value) {
	if (isEmpty(value))
		return "";
	else
		return value;
}

/**
 * 字串轉整數
 */
function toInt(val)
{
	var intVal = parseInt(val);
	if(intVal){
		return intVal;
	}
	return 0;		
};

/*
 * 首頁轉址
 * */
function indexLink()
{
	location.href = "Index";
}

function isEnglishNumber(str) {
    var regExp = /^[\d|a-zA-Z]+$/;
    if (regExp.test(str))
        return true;
    else
        return false;
}

function isNumber(str) {
    var regExp = /^[\d]+$/;
    if (regExp.test(str))
        return true;
    else
        return false;
}

function isEmail(str) {
    var regExp = /^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$/;
    if (regExp.test(str))
        return true;
    else
        return false;
}

function formatBtn(a,b,c,d){
	var e = a + "(\"" + b +  "\")";
	return "<a class='l-btn l-btn-plain' onclick='"+e+"'><span class='l-btn-left static'><span class='l-btn-text "+d+" l-btn-icon-left'>"+c+"</span></span></a>";
}

function formatBtnView(a,b){
	return "<a class='l-btn l-btn-plain'><span class='l-btn-left static'><span class='l-btn-text "+b+" l-btn-icon-left'>"+a+"</span></span></a>";
}

function dataEmpty(id,msg){
	$('#'+id).prev().find('.datagrid-body').html("<div class='label' style='margin-top: 10px;'><div class='label-icon icon-info'></div><div class='label-text'>"+msg+"</div></div>");
}

function disableSelect(index){
	$(this).datagrid('unselectRow', index);
}

function logger(msg){
	try
	{
		console.log(msg);
	}
	catch (e) 
	{
	    alert(msg);
    }
}
