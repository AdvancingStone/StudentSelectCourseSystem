//需要首先通过Jq来解决内容部分奇偶行的背景色不同
$(document).ready(function() {
	// 找到表格的内容区域中所有的奇数行
	// 使用even是为了把通过tbody tr返回的所有tr元素中，
	// 在数组里面下标是偶数的元素返回，因为这些元素，
	// 实际上才是我们期望的tbody里面的奇数行
	$("tbody tr:odd").css("background-color", "#EEEEEE");
	trEdit();// td的点击事件封装成一个函数
});
 //删除行* 
/*$(document).ready(function() {
	delTr();
});

// 删除
function delTr() {
	$(".delBtn").click(function() {
		$(this).parent().parent().remove();
	});
}

*/