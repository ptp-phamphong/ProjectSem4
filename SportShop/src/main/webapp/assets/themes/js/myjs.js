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

$("body").on("click", ".more", function() {
	$(this).remove();
	var clone = $("#ProductDetails").clone();
	clone.removeAttr("id");
	$("#containerDetail").append(clone);
})

$("#addProduct").click(function(event) {
	event.preventDefault();
	var formdata = $("#formAddProduct").serializeArray();
	json = {};
	arrayDetail = [];
	arrayImage = [];
	$.each(formdata, function(i, field) {
		json[field.name] = field.value;
	});
	
	$("#containerImage > .Images").each(function(){
		objectImage = {};
		img = $(this).find("#image").val();
		var imgg = img.substr(12, 100);
		var image = imgg.split(".");
		objectImage['img'] = image[0];
		arrayImage.push(objectImage);
	});
	
	json["Images"] = arrayImage;
	
	$("#containerDetail > .ProductDetails").each(function(){
		objectDetail = {};
		size = $(this).find("#size").val();
		price = $(this).find("#price").val();
		inventory = $(this).find("#inventory").val();
		objectDetail['size'] = size;
		objectDetail['price'] = price;
		objectDetail['inventory'] = inventory;
		
		arrayDetail.push(objectDetail);
	});
	
	json["ProductDetails"] = arrayDetail;

	$.ajax({
		url: "/SportShop/addNewProduct",
		type: 'POST',
		data: {
			datajson: JSON.stringify(json)
		},
		success: function(value) {
			swal("Success!", "Added new products!", "success");
		},
		error: function(xhr) {
			swal ( "Oops" ,  "Something went wrong!" ,  "error" );
		}
	});
	console.log(json);
})

var files = []
var imgName = "";
$("#image").change(function(event){
	files = event.target.files;
	var splits = files[0].name;
	imgName= splits.split('C:\\fakepath\\');
	forms = new FormData();
	forms.append("file",files[0])
	
	console.log(imgName);
	
	$.ajax({
		url: "/SportShop/UploadFile",
		type: 'POST',
		data: forms,
		contentType:false,
		processData:false,
		enctype:"multipart/form-data",
		success: function(value) {
			
		},
		error: function(xhr) {
			// Hmmm
		}
	})
})