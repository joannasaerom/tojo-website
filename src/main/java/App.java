import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import org.sql2o.*;
import java.sql.Date;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("navtemplate", "templates/nav-bar.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sunglasses", (request, response) -> {
      Map<String, Object>model = new HashMap<String, Object>();
      model.put("sunglasses", Sunglasses.all());
      model.put("template", "templates/sunglasses.vtl");
      model.put("navtemplate", "templates/nav-bar.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory", (request, response) -> {
      Map<String, Object>model = new HashMap<String, Object>();
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/inventory.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory/sunglasses", (request, response) -> {
      Map<String, Object>model = new HashMap<String, Object>();
      model.put("sunglasses", Sunglasses.all());
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/inventory-sunglasses.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory/sunglasses/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/sunglasses-add.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory/sunglasses/:sunglassesId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int sunglassesId = Integer.parseInt(request.params(":sunglassesId"));
      Sunglasses sunglass = Sunglasses.find(sunglassesId);
      model.put("sunglass", sunglass);
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/inventory-sunglass.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sunglasses/:sunglassesId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int sunglassesId = Integer.parseInt(request.params(":sunglassesId"));
      Sunglasses sunglass = Sunglasses.find(sunglassesId);
      model.put("sunglass", sunglass);
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/sunglass.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/inventory/sunglasses", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String imgURL = request.queryParams("imgURL");
      String description = request.queryParams("description");
      int price = Integer.parseInt(request.queryParams("price"));
      Sunglasses sunglass = new Sunglasses(name, imgURL, description, price);
      sunglass.save();
      response.redirect("/inventory/sunglasses");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory/sunglasses/:sunglassesId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sunglasses sunglass = Sunglasses.find(Integer.parseInt(request.params(":sunglassesId")));
      model.put("sunglass", sunglass);
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/sunglasses-edit.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/inventory/sunglasses/:sunglassesId/edit", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int sunglassesId = Integer.parseInt(request.queryParams("sunglassesId"));
      Sunglasses sunglass = Sunglasses.find(sunglassesId);
      sunglass.setName(request.queryParams("name"));
      sunglass.setImgUrl(request.queryParams("imgURL"));
      sunglass.setDescription(request.queryParams("description"));
      sunglass.setPrice(Integer.parseInt(request.queryParams("price")));
      sunglass.update();
      response.redirect("/inventory/sunglasses/" + sunglassesId);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory/sunglasses/:sunglassesId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sunglasses sunglass = Sunglasses.find(Integer.parseInt(request.params(":sunglassesId")));
      model.put("sunglass", sunglass);
      model.put("template", "templates/inventory-sunglass.vtl");
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template2", "templates/sunglasses-delete.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/inventory/sunglasses/:sunglassesId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sunglasses sunglass = Sunglasses.find(Integer.parseInt(request.params(":sunglassesId")));
      sunglass.delete();
      response.redirect("/inventory/sunglasses");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/accounts", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   model.put("user", );
    //   model.put("navtemplate", "templates/nav-bar.vtl");
    //   model.put("template", "templates/user.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine();)

    get("/sunglasses/:sunglassesId/purchase", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sunglasses sunglass  = Sunglasses.find(Integer.parseInt(request.params(":sunglassesId")));
      model.put("sunglass", sunglass);
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/sunglass-purchase.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sunglasses/:sunglassesId/purchase/invoice", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String phone = request.queryParams("phone");
      String email = request.queryParams("email");
      String creditCardNum = request.queryParams("creditCard");
      String street = request.queryParams("street");
      String city = request.queryParams("city");
      String state = request.queryParams("state");
      int zipcode = (Integer.parseInt(request.queryParams("zipcode")));
      User user = new User(name, creditCardNum, phone, email, street, city, state, zipcode);
      user.save();
      Sunglasses sunglass = Sunglasses.find(Integer.parseInt(request.params(":sunglassesId")));
      sunglass.setCustomerId(user.getId());
      sunglass.purchase();
      model.put("sunglass", sunglass);
      model.put("user", user);
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/invoice.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/search", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String searchInput = request.queryParams("searchInput");
      model.put("sunglasses", Sunglasses.search(searchInput));
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/search-result.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/search", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
  
      model.put("navtemplate", "templates/nav-bar.vtl");
      model.put("template", "templates/search-result.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
