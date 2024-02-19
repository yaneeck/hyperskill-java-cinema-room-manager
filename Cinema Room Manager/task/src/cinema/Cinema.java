package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numOfRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = scanner.nextInt();

        int chosenRow;
        int chosenSeat;

        // every value is in form "row,seat"
        String[] takenSeats = new String[numOfRows * numOfSeats];
        int numOfTickets = 0;

        int currentIncome = 0;
        int totalIncome = calculateTotalIncome(numOfRows, numOfSeats);

        int menuChoice;

        // menu
        do {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            menuChoice = scanner.nextInt();

            switch(menuChoice) {
                case 1:
                    printCinemaRoom(takenSeats, numOfRows, numOfSeats);
                    break;
                case 2:
					while (true) {
						System.out.println("Enter a row number:");
						chosenRow = scanner.nextInt();

						System.out.println("Enter a seat number in that row:");
						chosenSeat = scanner.nextInt();

                        if (chosenRow > numOfRows || chosenRow <= 0 || chosenSeat > numOfSeats || chosenSeat <= 0) {
                            System.out.println("Wrong input!");
                            continue;
                        }

                        // an actual ticket price is returned if the purchase has succeeded, 0 otherwise
                        int ticketPrice = buyTicket(chosenRow, chosenSeat, takenSeats, numOfRows, numOfSeats);
                        if (ticketPrice > 0) {
                            takenSeats[numOfTickets] = chosenRow + "," + chosenSeat;
                            numOfTickets++;
                            currentIncome += ticketPrice;
                            break;
                        }
                    }

                    break;
                case 3:
                    show_statistics(numOfTickets, numOfRows * numOfSeats, currentIncome, totalIncome);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        } while (menuChoice != 0);

    }

    private static int calculateTotalIncome(int rows, int seats) {
        int cheaperRows = 0;
        if (rows * seats > 60)
            cheaperRows =  rows / 2;

        return 8 * (rows - cheaperRows) * seats + 10 * cheaperRows * seats ;
    }

    private static void show_statistics(int purchasedTickets, int allTickets, int currentIncome, int totalIncome) {
        System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);
        float percentage = (float) 100.0 * purchasedTickets / allTickets;
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }

    private static int buyTicket(int chosenRow, int chosenSeat, String[] takenSeats, int numOfRows, int numOfSeats) {
		// calculate a ticket price
        int ticketPrice = 10;
        if (numOfRows * numOfSeats > 60)
            if (chosenRow > numOfRows / 2)
                ticketPrice = 8;

        if (isSeatTaken(chosenRow, chosenSeat, takenSeats)) {
           System.out.println("That ticket has already been purchased!");
           System.out.println();
           return 0;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        return ticketPrice;
    }

    private static boolean isSeatTaken(int row, int seat, String[] takenSeats) {
        for (String takenSeat : takenSeats) {
            // some array items may be null
            if (takenSeat == null) {
                continue;
            }
            // items in takenSeats look like "row,seat"
            String[] item = takenSeat.split(",");
            if (row == Integer.parseInt(item[0]) && seat == Integer.parseInt(item[1])) {
                return true;
            }
        }
        return false;
    }

    private static void printCinemaRoom(String[] takenSeats, int numRows, int numSeats) {
        System.out.println("Cinema:");

        // print numbers of seats
        System.out.print("  ");
        for(int j = 1; j <= numSeats; j++)
            System.out.print(j + " ");
        System.out.println();

        // print numbers of rows and all the seats (S)
        for (int i = 1; i <= numRows; i++) {
            System.out.print(i + " "); // a row number
            for (int j = 1; j <= numSeats; j++) {
                String seatSymbol = "S ";
                // switch S for B if a seat is taken (a ticket was bought)
                for (String takenSeat : takenSeats) {
                    if (takenSeat == null) {
                        continue;
                    }
                    String[] seat = takenSeat.split(",");
                    if (i == Integer.parseInt(seat[0]) && j == Integer.parseInt(seat[1])) {
                        seatSymbol = "B "; // a seat
                        break;
                    }
                }
                System.out.print(seatSymbol); // a seat
            }
            System.out.println();
        }
    }
}
