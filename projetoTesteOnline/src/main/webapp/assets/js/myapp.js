$(function(){
	// solving the active menu problem
	switch(menu){
	
		case 'About Us':
			$('#aboutUs').addClass('active');
			break;
			
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
			
		case 'View Products':
			$('#listProducts').addClass('active');
			break;
		
		default:
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;		
	
	}
}

);