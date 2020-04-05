jQuery(function($) {
		var validation_holder;

		$("form#register_form input[name='submit']")
				.click(
						function() {

							var validation_holder = 0;

							var name = $(
									"form#register_form input[name='name']")
									.val();
							var description = $(
							"form#register_form input[name='description']")
							.val();	
							var yearOfStudy = $(
							"form#register_form input[name='yearOfStudy']")
							.val();	
							
							/* validation start */
							if (name == "") {
								$("span.val_name").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_name").html("");
							}
							
							if (description == "") {
								$("span.val_description").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_description").html("");
							}
							
							if (yearOfStudy == "") {
								$("span.val_yearOfStudy").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_yearOfStudy").html("");
							}
						
						
							if (validation_holder == 1) { // if have a field is blank, return false
								$("p.validate_msg").slideDown("fast");
								return false;
							}
							validation_holder = 0; // else return true
							/* validation end */
						}); // click end 

	});