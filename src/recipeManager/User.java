package recipeManager;

public class User {
	
	private String name;
	private String[][] recipesRated = new String[0][];
	private String[] recipesFavorited = new String[0];
	
	public void setName(String setName) {
		name = setName;
	}
	public void setRecipesRated(String recipe, double rating) {
		//adds the recipe to the list of recipes that has been rated by this user
		//takes the rating for this recipe
	}
	public void setFavoriteRecipe() {
		//takes a recipe and adds it to this user's favorites
	}
	public String getName() {
		return name;
	}
	public String[][] getRecipesRated() {
		return recipesRated;
	}
	public String[] getFavoriteRecipes() {
		return recipesFavorited;
	}

}
