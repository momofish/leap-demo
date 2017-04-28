package leap.api.controller;

import leap.web.annotation.Path;
import leap.web.annotation.http.GET;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;

@Path("/api")
public class ApiDemoController extends ApiController {
    @GET
    public ApiResponse<ApiModel> getModel(){
        return ApiResponse.of(new ApiModel("api model"));
    }

    private class ApiModel {
        private String name;

        public ApiModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}