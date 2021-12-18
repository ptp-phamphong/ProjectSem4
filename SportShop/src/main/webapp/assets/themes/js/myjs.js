// Ajax đổi hình ảnh ở product detail
function changeImage(param) {
	var idImg = param;
	$.ajax({
		url: "/SportShop/ChangeImageProduct",
		type: 'get',
		data: {
			imgItem: idImg
		},
		success: function(value) {
			var main = $("#mainImg");
			main.empty();
			main.append(value);
		},
		error: function(xhr) {
			// Hmmm
		}
	})
}
