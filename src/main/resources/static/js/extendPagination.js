;(function($){
    $.fn.extend({
        "jeesns_page":function(form){
            var $this=this;
            //定义分页结构体
            var pageinfo={
                url:$(this).attr("url"),
                currentPage : $(this).attr("currentPage")*1, // 当前页码
                pageCount : $(this).attr("pageCount")*1 // 总页码

            };


            if(pageinfo.pageCount<2)
                return false;
            //初始起始页数、结束页数
            var start=0,end=10;
            if(pageinfo.currentPage>=10)
                start=pageinfo.currentPage-5;

            if(pageinfo.pageCount>pageinfo.currentPage+5)
                end=pageinfo.currentPage+5;
            else
                end=pageinfo.pageCount;
            var html=[];
            // html.push("<ul>");
            if(pageinfo.currentPage!=1)
            //如果不是第一页则有前一页
                html.push("<li class='prev'><a href='javascript:void(0)'>&lt;&lt;</a></li>");
            if(pageinfo.pageCount>10&&pageinfo.currentPage>9)
                html.push("<li class='num'><a href='javascript:void(0)'>1</a></li>");
            for(var i=start;i<end;i++){
                if((i+1)==pageinfo.currentPage)
                    html.push("<li><span class='current'>"+(i+1)+"</span></li>");
                else
                    html.push("<li class='num'><a href='javascript:void(0)'>"+(i+1)+"</a></li>");
            }

            if(pageinfo.pageCount>10&&pageinfo.currentPage<pageinfo.pageCount-4)
                html.push("<li class='num'><a href='javascript:void(0)'>"+pageinfo.pageCount+"</a></li>");
            if(pageinfo.currentPage!=pageinfo.pageCount)
                html.push("<li class='next'><a href='javascript:void(0)'>&gt;&gt;</a></li>");
            // html.push("</ul>");


            $this.html(html.join(""));
            //绑定数据处理函数
            $this.find(".num a").bind("click",function(){
                redirectTo($(this).html());
            });
            $this.find(".prev a").bind("click",function(){
                redirectTo(pageinfo.currentPage-1);
            });
            $this.find(".next a").bind("click",function(){
                redirectTo(pageinfo.currentPage+1);
            });

            function redirectTo(page){

                var url=pageinfo.url;
                if(url.indexOf("?")==-1)
                    url+="?";
                else
                    url+="&";
                url+="pageNo="+page;
                window.location.href=url;


            }
            return $this;
        }
    });

})(jQuery);