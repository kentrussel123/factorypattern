package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("\nChoose your pet number: ");
            Integer choice = input.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break; // Exit the loop if choice is 3
            }

            PetRecord petFile = new PetRecord();
            Pet pet;

            switch (choice) {
                case 1:
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepperd");
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    continue; // Continue to the next iteration of the loop for an invalid choice
            }

            System.out.println("Pet id is " + petFile.getPetId());
            System.out.println("Pet name is " + petFile.getPetName());
            System.out.println("Pet kind: " + petFile.getPet().getClass().getSimpleName());

            if (pet instanceof Dog) {
                System.out.println("Breed: " + ((Dog) pet).getBreed());
            } else if (pet instanceof Cat) {
                System.out.println("Number of Lives: " + ((Cat) pet).getNoOfLives());
            }

            System.out.println("Communication sound: " + petFile.getPet().makeSound());
            System.out.println("Play mode: " + petFile.getPet().play());
        }
    }
}
