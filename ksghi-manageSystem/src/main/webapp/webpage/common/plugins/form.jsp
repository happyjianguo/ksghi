<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.form.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.validate.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.validate-additional-methods.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.validate-messages_zh.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.validate.bootstrap.js"></script>
<!--
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/jquery.validate.bootstrap.popover.js"></script>
-->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/ui/core/plugins/form/js/encrypt.js"></script>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/assets/ui/core/plugins/form/css/jquery.validate.css"></link>
<script type="text/javascript">
    //数字校验，只能是数字，最多包含两位小数
    jQuery.validator.addMethod("isDoubleDigit", function (value, element) {
        var tel = /^(-?[0|[1-9]+)(\.[0-9]{1,2})?$/;
        return this.optional(element) || (tel.test(value));
    }, "请输入数字，最多包含两位小数");
    //url地址验证
    jQuery.validator.addMethod("isUrl", function (value, element) {
        var reg = /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;

        return this.optional(element) || (reg.test(value));
    }, "请填写正确的url。");

    //IP地址验证
    jQuery.validator.addMethod("ip", function (value, element) {
        var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
        return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
    }, "请填写正确的IP地址。");

    // 联系电话(手机/电话皆可)验证
    jQuery.validator.addMethod("isPhone", function (value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/;
        var tel = /^\d{3,4}-?\d{7,9}$/;
        return this.optional(element) || (tel.test(value) || mobile.test(value));

    }, "请正确填写正确的联系电话");

    // 邮政编码验证
    jQuery.validator.addMethod("isZipCode", function (value, element) {
        var tel = /^[0-9]{6}$/;
        return this.optional(element) || (tel.test(value));
    }, "请正确填写您的邮政编码");

    //校验同一属性的多个值之间的值唯一
    jQuery.validator.addMethod("uniqueTo", function (value, element, param) {
        var equalTotal = 0;
        $(":input[name^='" + param + "']").each(function () {
            var $this = $(this);
            var _val = $this.val();
            if (value === _val) {
                equalTotal++;
            }
        });
        return this.optional(element) || (equalTotal == 1);
    }, "该属性值已经存在");

    //校验值的大小
    jQuery.validator.addMethod("overTo", function (value, element, param) {
        var num1 = Number($(param).val());
        var num2 = Number(value);
        var flag = false;
        if (!isNaN(num1) && !isNaN(num1)) {
            flag = num2 > num1;
        }
        return this.optional(element) || flag;
    }, "输入值过小");


    //文本框只能输入数字字母下划线
    jQuery.validator.addMethod("isSpecialDigit", function (value, element) {
        var tel = /^[A-Za-z0-9_-]*$/g;
        return this.optional(element) || (tel.test(value));
    }, "请输入汉字、英文字母、数字、下划线");

    //相同name时根据id验证(主要针对循环表格中有相同name属性的表单元校验)
    /* if ($.validator) {
        $.validator.prototype.elements = function () {
            var validator = this,
               rulesCache = {};
            return $([]).add(this.currentForm.elements)
            .filter(":input")
            .not(":submit, :reset, :image, [disabled]")
            .not(this.settings.ignore)
            .filter(function () {
                var elementIdentification = this.id || this.name;
                !elementIdentification && validator.settings.debug && window.console && console.error("%o has no id nor name assigned", this);
                if (elementIdentification in rulesCache || !validator.objectLength($(this).rules()))
                    return false;
                rulesCache[elementIdentification] = true;
                return true;
                });
            };
    }
     */
    if ($.validator) {
        $.validator.prototype.elements = function () {
            var validator = this,
                rulesCache = {};
            // Select all valid inputs inside the form (no submit or reset buttons)
            return $(this.currentForm)
                .find("input, select, textarea, [contenteditable]")
                .not(":submit, :reset, :image, :disabled")
                .not(this.settings.ignore)
                .filter(function () {
                    var name = this.id || this.name || $(this).attr("name"); // For contenteditable
                    if (!name && validator.settings.debug && window.console) {
                        console.error("%o has no name assigned", this);
                    }
                    // Set form expando on contenteditable
                    if (this.hasAttribute("contenteditable")) {
                        this.form = $(this).closest("form")[0];
                    }
                    // Select only the first element for each name, and only those with rules specified
                    if (name in rulesCache || !validator.objectLength($(this).rules())) {
                        return false;
                    }
                    rulesCache[name] = true;
                    return true;
                });
        }
    }

</script>
