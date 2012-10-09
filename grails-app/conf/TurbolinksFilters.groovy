/**
 * This is the servlet filter that handles the X-XHR-Location and X-XHR-Referer 
 * to properly handle redirects and to pass along the correct referer.
 * 
 * @author Bobby Warner
 */
class TurbolinksFilters {
	def filters = {
		allURIs(uri: '/**') {
			before = {
				if (request.getHeader("X-XHR-Referer")) {
            		log.info("X-XHR-Referer check true")
            		
        		} else {
        			log.info("X-XHR-Referer check false")
        			
        		}
			}

			after = { Map model ->
				response.addHeader('X-XHR-Current-Location', request.forwardURI)
			}
		}
	}
}
