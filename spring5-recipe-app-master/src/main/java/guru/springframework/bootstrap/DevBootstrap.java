package guru.springframework.bootstrap;

import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	CategoryRepository categoryRepository;
	UnitOfMeasureRepository unitOfMeasureRepository;
	RecipeRepository recipeRepository;
	
	public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("something");
		initData();
	}

	private void initData() {
		
		Notes notes = new Notes();
		notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		
		Recipe perfectGuacamole = new Recipe();
		perfectGuacamole.setCookTime(10);
		perfectGuacamole.setDescription("The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips. Watch how to make guacamole - it's easy!");
		perfectGuacamole.setDifficulty(Difficulty.EASY);
		perfectGuacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n");
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setServings(4);
		perfectGuacamole.setSource("BY ELISE BAUER");
		perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		perfectGuacamole.setNotes(notes);
		
		//perfectGuacamole.setCategories(categories );
		recipeRepository.save(perfectGuacamole);
		
	}
}
