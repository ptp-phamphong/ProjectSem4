//Xử lý phân trang

function pagination() {
	//Định nghĩa mỗi trang có bao nhiêu sản phẩm
	var numPerPage = 9;


	//Lấy ra số lượng sản phẩm trong db 
	var numberProduct = document.getElementById("numberProduct").value;

	//Lấy ra tổng số trang
	var numPage = 0;
	if (numberProduct % numPerPage == 0) {
		numPage = numberProduct / numPerPage;
	} else {
		numPage = Math.floor(numberProduct / numPerPage) + 1;
	}
	//Okay lấy ra được tổng số trang

	//Giờ phải in ra cái danh sách trang, cái đống html hiển thị đó
	document.getElementById("pagination").innerHTML += "<li class='page-item'><button class='page-link' onclick='changePage("
		+ 0 + ")'>Previous</button></li>";
	for (var i = 1; i <= numPage; i++) {
		document.getElementById("pagination").innerHTML += "<li class='page-item'><button id='pag"
			+ i
			+ "' class='page-link' onclick='changePage("
			+ i
			+ ")'>"
			+ i + "</button></li>";
	}
	document.getElementById("pagination").innerHTML += "<li class='page-item'><button class='page-link' onclick='changePage("
		+ (parseInt(numPage) + 1) + ")'>Next</button></li>";
	//In dell gì nhìn dài thế thôi mà kệ đi

	function changePage(pageTo) {
		var currentPage = document.getElementById("currentPage").value;

		//Mặc định là trang trước là 0, trang kế thì là trang cuối cùng
		if (pageTo == (parseInt(numPage) + 1)) {
			if (currentPage == numPage) {
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage + 1
			pageTo = parseInt(currentPage) + 1;
		}

		if (pageTo == 0) { //Hiển thị trước đó hoặc là trang đầu tiên
			if (currentPage == 1) {//Nếu đã là trang đầu thì bỏ thôi, ko cần làm gì cả
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage - 1
			pageTo = currentPage - 1;
		}

		//Xóa màu cho cái trang cũ
		document.getElementById("pag" + currentPage).style.backgroundColor = "";

		//Đầu tiên chuyển cái page current thành page to
		document.getElementById("currentPage").value = pageTo;

		//Tô màu cho cái ô hiển thị số trang active
		document.getElementById("pag" + pageTo).style.backgroundColor = "yellow";

		//ẩn đi những sản phẩm ở trang trước đó
		for (var i = ((currentPage - 1) * numPerPage + 1); i <= currentPage
			* numPerPage; i++) {
			if (document.getElementById("Product" + i)) {
				document.getElementById("Product" + i).style.display = "none";
			}
		}
		//Hiện lên những sản phẩm ở trang muốn đến
		for (var i = ((pageTo - 1) * numPerPage + 1); i <= pageTo * numPerPage; i++) {
			document.getElementById("Product" + i).style.display = "";
		}//Lưu ý, từ đây xuống sẽ bị lỗi đấy đm

		//Mặc định là trang trước là 0, trang kế thì là trang cuối cùng
		if (pageTo == (parseInt(numPage) + 1)) {
			if (currentPage == numPage) {
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage + 1
			pageTo = parseInt(currentPage) + 1;
		}

		if (pageTo == 0) { //Hiển thị trước đó hoặc là trang đầu tiên
			if (currentPage == 1) {//Nếu đã là trang đầu thì bỏ thôi, ko cần làm gì cả
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage - 1
			pageTo = currentPage - 1;
		}

		//Xóa màu cho cái trang cũ
		document.getElementById("pag" + currentPage).style.backgroundColor = "";

		//Đầu tiên chuyển cái page current thành page to
		document.getElementById("currentPage").value = pageTo;

		//Tô màu cho cái ô hiển thị số trang active
		document.getElementById("pag" + pageTo).style.backgroundColor = "yellow";

		//ẩn đi những sản phẩm ở trang trước đó
		for (var i = ((currentPage - 1) * numPerPage + 1); i <= currentPage
			* numPerPage; i++) {
			if (document.getElementById("Product" + i)) {
				document.getElementById("Product" + i).style.display = "none";
			}
		}
		//Hiện lên những sản phẩm ở trang muốn đến
		for (var i = ((pageTo - 1) * numPerPage + 1); i <= pageTo * numPerPage; i++) {
			document.getElementById("Product" + i).style.display = "";
		}//Lưu ý, từ đây xuống sẽ bị lỗi đấy đm

		//Xong rồi, ez vl
	}


	/*changePage(1);*/

	//Lúc mới vào thì xử lý cái số trang trước.
	window.onload = function() {
		changePage(1);
	};
}


//Định nghĩa mỗi trang có bao nhiêu sản phẩm
	var numPerPage = 9;


	//Lấy ra số lượng sản phẩm trong db 
	var numberProduct = document.getElementById("numberProduct").value;

	//Lấy ra tổng số trang
	var numPage = 0;
	if (numberProduct % numPerPage == 0) {
		numPage = numberProduct / numPerPage;
	} else {
		numPage = Math.floor(numberProduct / numPerPage) + 1;
	}
	//Okay lấy ra được tổng số trang

	//Giờ phải in ra cái danh sách trang, cái đống html hiển thị đó
	document.getElementById("pagination").innerHTML += "<li class='page-item'><button class='page-link' onclick='changePage("
		+ 0 + ")'>Previous</button></li>";
	for (var i = 1; i <= numPage; i++) {
		document.getElementById("pagination").innerHTML += "<li class='page-item'><button id='pag"
			+ i
			+ "' class='page-link' onclick='changePage("
			+ i
			+ ")'>"
			+ i + "</button></li>";
	}
	document.getElementById("pagination").innerHTML += "<li class='page-item'><button class='page-link' onclick='changePage("
		+ (parseInt(numPage) + 1) + ")'>Next</button></li>";
	//In dell gì nhìn dài thế thôi mà kệ đi

	function changePage(pageTo) {
		var currentPage = document.getElementById("currentPage").value;

		//Mặc định là trang trước là 0, trang kế thì là trang cuối cùng
		if (pageTo == (parseInt(numPage) + 1)) {
			if (currentPage == numPage) {
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage + 1
			pageTo = parseInt(currentPage) + 1;
		}

		if (pageTo == 0) { //Hiển thị trước đó hoặc là trang đầu tiên
			if (currentPage == 1) {//Nếu đã là trang đầu thì bỏ thôi, ko cần làm gì cả
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage - 1
			pageTo = currentPage - 1;
		}

		//Xóa màu cho cái trang cũ
		document.getElementById("pag" + currentPage).style.backgroundColor = "";

		//Đầu tiên chuyển cái page current thành page to
		document.getElementById("currentPage").value = pageTo;

		//Tô màu cho cái ô hiển thị số trang active
		document.getElementById("pag" + pageTo).style.backgroundColor = "yellow";

		//ẩn đi những sản phẩm ở trang trước đó
		for (var i = ((currentPage - 1) * numPerPage + 1); i <= currentPage
			* numPerPage; i++) {
			if (document.getElementById("Product" + i)) {
				document.getElementById("Product" + i).style.display = "none";
			}
		}
		//Hiện lên những sản phẩm ở trang muốn đến
		for (var i = ((pageTo - 1) * numPerPage + 1); i <= pageTo * numPerPage; i++) {
			document.getElementById("Product" + i).style.display = "";
		}//Lưu ý, từ đây xuống sẽ bị lỗi đấy đm

		//Mặc định là trang trước là 0, trang kế thì là trang cuối cùng
		if (pageTo == (parseInt(numPage) + 1)) {
			if (currentPage == numPage) {
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage + 1
			pageTo = parseInt(currentPage) + 1;
		}

		if (pageTo == 0) { //Hiển thị trước đó hoặc là trang đầu tiên
			if (currentPage == 1) {//Nếu đã là trang đầu thì bỏ thôi, ko cần làm gì cả
				return;
			}
			//Trường hợp còn lại thì pageTo = currentPage - 1
			pageTo = currentPage - 1;
		}

		//Xóa màu cho cái trang cũ
		document.getElementById("pag" + currentPage).style.backgroundColor = "";

		//Đầu tiên chuyển cái page current thành page to
		document.getElementById("currentPage").value = pageTo;

		//Tô màu cho cái ô hiển thị số trang active
		document.getElementById("pag" + pageTo).style.backgroundColor = "yellow";

		//ẩn đi những sản phẩm ở trang trước đó
		for (var i = ((currentPage - 1) * numPerPage + 1); i <= currentPage
			* numPerPage; i++) {
			if (document.getElementById("Product" + i)) {
				document.getElementById("Product" + i).style.display = "none";
			}
		}
		//Hiện lên những sản phẩm ở trang muốn đến
		for (var i = ((pageTo - 1) * numPerPage + 1); i <= pageTo * numPerPage; i++) {
			document.getElementById("Product" + i).style.display = "";
		}//Lưu ý, từ đây xuống sẽ bị lỗi đấy đm

		//Xong rồi, ez vl
	}


	/*changePage(1);*/

	//Lúc mới vào thì xử lý cái số trang trước.
	window.onload = function() {
		changePage(1);
	};





function sendEmail() {

	if (document.getElementById("Email").value == "") {
		alert("Please type your email");
		return false;
	}
	document.getElementById('divOTP').style.display = "block";
	//Cú pháp ajax, gửi mail thầm kín
	$.ajax({
		url: "sendEmailRegister",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: { "email": JSON.parse(JSON.stringify(document.getElementById("Email").value)) },
		success: function(data) {
			//hiện ra cái ô đã gửi mail thành công và báo nó vào mà check mail đi đm
			alert(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
}

//Nút thêm vào giỏ hàng
function addToCart(idProduct) {
	$.ajax({
		url: "/SportShop/ajax/addItemToCart",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {
			"idProduct": JSON.parse(JSON.stringify(idProduct)),
			"quantity": JSON.parse(JSON.stringify(1)),
			"inDetails": false,
		},
		success: function(data) {
			console.log(data);
			$('#headerCart').html(data);
			jQuery("#productstack").load("/SportShop/ajax/productStack");

		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
}

//Thêm vào giỏ hàng trong chi tiết sản phẩm
function addToCartInDetail() {
	$.ajax({
		url: "/SportShop/ajax/addItemToCartInDetail",
		type: "GET",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {
			"idProduct": JSON.parse(JSON.stringify(document.getElementById("listProductDetails").value)),
			"quantity": JSON.parse(JSON.stringify(document.getElementById("quantity").value)),
			"inDetails": false,
		},
		success: function(data) {
			console.log(data);
			$('#headerCart').html(data);
			jQuery("#productstack").load("/SportShop/ajax/productStack");
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
}



//Tăng số lượng trong giỏ hàng
function increase(id) {
	$.ajax({
		url: "/SportShop/ajax/increseQuantity",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: { "idProductDetail": JSON.parse(JSON.stringify(id)) },
		success: function(data) {
			$('#mainCart').html(data);
			jQuery("#productstack").load("/SportShop/ajax/productStack");
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
};


//Giảm số lượng trong giỏ hàng
function decrease(id) {
	$.ajax({
		url: "/SportShop/ajax/decreaseQuantity",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: { "idProductDetail": JSON.parse(JSON.stringify(id)) },
		success: function(data) {
			$('#mainCart').html(data);
			jQuery("#productstack").load("/SportShop/ajax/productStack");
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
};

//Xóa 1 phần tử trong giỏ hàng
function removeItemCart(id) {
	$.ajax({
		url: "/SportShop/ajax/removeItemCart",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: { "idProductDetail": JSON.parse(JSON.stringify(id)) },
		success: function(data) {
			$('#mainCart').html(data);
			jQuery("#headerCart").load("/SportShop/ajax/showHeaderCart");
			jQuery("#productstack").load("/SportShop/ajax/productStack");

		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;
}

function addFilter(id, type) {
	$.ajax({
		url: "/SportShop/ajax/addFilter",
		type: "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: { "id": id, "type": type },
		success: function(data) {
			jQuery("#filter_Input").load("/SportShop/ajax/showFilterInput");
			$('#product_List').html(data);
			pagination();
			changePage(1);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + '\nSTATUS: ' + textStatus + '\nERROR THROWN: '
				+ errorThrown);
		}
	});
	return false;;
}




