

/**
* author MAB  - 2017/08/06
*
*
**/
$.getScript("js/md5-min.js");
$('#loginForm').submit(function( event ) {
  
  $(this).find('input:password').val(hex_md5($(this).find('input:password').val()));
  
});