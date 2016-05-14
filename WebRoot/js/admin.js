function skip(name,page){
	var height = $("body").height()-80;
	$(".iframe").load(getUrl()+"/"+name+"?page="+page,{},function(data){
        var _height = $(".iframe").height();
        if(_height>height){
            $(".material-left").css({
                'min-height': _height,
            });
        }else{
            $(".material-left").css({
                'min-height': height,
            });
        }
        $('html, body').animate({scrollTop : $(".result-table").offset().top}, 'slow');
    });
}
function getUrl(){
	var pathname = window.location.pathname.substring(1);
	return window.location.protocol + "//" + window.location.host + "/" + pathname.substring(0,pathname.indexOf("/"));
}