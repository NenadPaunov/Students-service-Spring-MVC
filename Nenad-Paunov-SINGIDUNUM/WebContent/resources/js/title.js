jQuery(function($) {
		var validation_holder;

		$("form#register_form input[name='submit']")
				.click(
						function() {

							var validation_holder = 0;

							var titleName = $(
									"form#register_form input[name='titleName']")
									.val();
							

							/* validation start */
							if (titleName == "") {
								$("span.val_titleName").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_titleName").html("");
							}
							
							if (validation_holder == 1) { // if have a field is blank, return false
								$("p.validate_msg").slideDown("fast");
								return false;
							}
							validation_holder = 0; // else return true
							/* validation end */
						}); // click end 

	});