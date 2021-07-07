
function get_max_height_book_cover() {
	book_cover_heights = []

	$( ".book-cover-image" ).each(function() {
		book_cover_heights.push($(this).height())
	});

	max_book_cover_height = Math.max.apply(null, book_cover_heights);
	console.log(max_book_cover_height);
	return max_book_cover_height;
}

function set_cover_image_height(height) {
    var elements = document.querySelectorAll('.book-cover-image-wrapper');

    elements.forEach(function(book_cover_wrapper){
        book_cover_wrapper.style.height = height + "px";
    });

};


max_book_cover_height = get_max_height_book_cover();
set_cover_image_height(max_book_cover_height);
