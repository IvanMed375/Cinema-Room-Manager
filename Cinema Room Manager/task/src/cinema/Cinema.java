package cinema;

import java.util.Scanner;

public class Cinema {

    public static void showTheSeats(char[][] cinema, int rows, int seats) {
        System.out.println();
        System.out.println("Cinema: ");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++){
                if (j == 0) {
                    if(i != 0){
                        System.out.print(i + " ");
                    } else {
                        System.out.print("  ");
                    }
                } else if (i == 0){
                    System.out.print(j + " ");
                } else {
                    System.out.print(cinema[i-1][j-1] + " ");
                }
            }
            System.out.println();
        }
    }
    public static int buyATicket(boolean smallCinema, int priceForFrontHalf,
                                  int priceForBackHalf, int rows, int seats,
                                  char[][] cinema) {
        int price;
        int row = 0;
        int seat;
        boolean correctInput = false;
        Scanner scan = new Scanner(System.in);
        
        while (!correctInput) {
            
            System.out.println("Enter a row number:");
            row = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scan.nextInt();



            if (row > rows || row < 1 || seat > seats || seat < 1) {
                System.out.println("Wrong input");
                continue;
            } 

            if (cinema[row - 1][seat - 1] != 'B') {
                cinema[row - 1][seat - 1] = 'B';
                correctInput = true;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }


            if (smallCinema) {
                price = priceForFrontHalf;
            } else {
                if (row <= rows / 2) {
                    price = priceForFrontHalf;
                } else {
                    price = priceForBackHalf;
                }
            }

            System.out.printf("Ticket price: $%d%n", price);
            return price;
    }

    public static void statistics(int ticketsSold, int totalSeats, int income,
                                  int profit) {
        System.out.format("Number of purchased tickets: %d%n", ticketsSold);
        float percentage = ticketsSold * 100f / totalSeats;
        System.out.format("Percentage: %.2f%c%n", percentage, '%');
        System.out.format("Current income: $%d%n", income);
        System.out.format("Total income: $%d%n", profit);
    }

    public static void main(String[] args) {
        char[][] cinema = new char[9][9];
        Scanner scan = new Scanner(System.in);
        int rows;Cinema.java
        int seats;
        final int priceForFrontHalf = 10;
        final int priceForBackHalf = 8;
        int action;
        int ticketsSold = 0;
        int income = 0;
        final int totalSeats;
        final int profit;
        boolean smallCinema = false;
        boolean exit = false;

        System.out.println("Enter the number of rows:");
        rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scan.nextInt();

        totalSeats = rows * seats;

        if (totalSeats <= 60) {
            smallCinema = true;
            profit = 10 * totalSeats;
        } else {
            profit = (totalSeats * 8) + ((rows / 2) * seats * 2);
        }
        System.out.println();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                cinema[i][j] = 'S';
            }
        }


        while (!exit) {
            System.out.println();
            System.out.println("1. Show the seats\n2. Buy a ticket\n" +
                    "3. Statistics\n0. Exit");
            action = scan.nextInt();
            switch (action) {
                case 1:
                    showTheSeats(cinema, rows, seats);
                    break;
                case 2:
                    income += buyATicket(smallCinema, priceForFrontHalf,
                            priceForBackHalf, rows, seats, cinema);
                    ticketsSold++;
                    break;
                case 3:
                    statistics(ticketsSold, totalSeats, income, profit);
                    break;
                case 0:
                    exit = true;
                default:
                    break;
            }
        }








    }
}