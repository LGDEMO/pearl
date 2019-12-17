// 动态高亮菜单
$(function () {
    $(".sidebar-menu").find("li").each(function () {
        var a = $(this).find("a:first")[0];
        var url = location.pathname;
        url=url.replace("/gem/","");
        if ($(a).attr("href") === url) {
            console.log(url+"=="+$(a).attr("href"));
            $(this).addClass("active");
            var pid = $(a).attr("data-pid");
            $(".sidebar-menu").find("li").each(function () {
                var a2 = $(this).find("a:first")[0];
                if ($(a2).attr("data-id") === pid) {
                    console.log(pid+"=="+$(a2).attr("data-id"));
                    $(this).addClass("active");
                    var pid2 = $(a2).attr("data-pid");
                    $(".sidebar-menu").find("li").each(function () {
                        var a3 = $(this).find("a:first")[0];
                        if ($(a3).attr("data-id") === pid2) {
                            $(this).addClass("active");
                            var pid3 = $(a3).attr("data-pid")
                            $(".sidebar-menu").find("li").each(function () {
                                var a4 = $(this).find("a:first")[0];
                                if ($(a4).attr("data-id") === pid3) {
                                    $(this).addClass("active");
                                }
                            })
                        }
                    })
                }
            })
        } else {
            $(this).removeClass("active");
        }
    });
})
