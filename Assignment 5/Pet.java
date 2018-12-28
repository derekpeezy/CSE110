
public class Pet
{
    private String pet_name;
    private int pet_age;
    private boolean adopted;
    
    public Pet() {
        pet_age = 1;
        adopted = false;
        pet_name = "Spot";
    }
    
    public Pet(String pet_name_c, int pet_age_c) {
    	 pet_name = pet_name_c;
         pet_age = pet_age_c;
         adopted = false;
	}

	String getName() {
        return pet_name;
    }
    
    String setName(String new_name) {
        pet_name = new_name;
        return pet_name;
    }
    
    int getAge() {
        return pet_age;
    }
    
    int setAge() {
        pet_age = pet_age + 1;
        return pet_age;
    }
    
    boolean getAdoptedStatus() {
        return adopted;
    }
    
    boolean setAdoptedStatus() {
        adopted = true;
        return adopted;
    }
}