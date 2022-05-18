package com.ihsan;

import java.util.*;

public class Theatre {
    private final String name;
    private List<Seat> seats = new ArrayList<Seat>();

    public Theatre(String name) {
        this.name = name;
        for (int i = 0 ; i <= 10; i++) {
            Seat seat = new Seat("A"+i);
            seats.add(seat);
        }
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(String seatName) {
        Seat seat = new Seat(seatName);
        int foundSeat = Collections.binarySearch(seats, seat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        }
        System.out.println("Seat has been reserved, try another");
        return false;
    }

    public void printAllSeats() {
        for (int i = 0 ; i < seats.size() ; i++) {
            System.out.println(seats.get(i).getSeatName());
        }
    }

    class Seat implements Comparable<Seat> {
        private final String seatName;
        private boolean reserved = false;

        public Seat(String seatName) {
            this.seatName = seatName;
        }

        public String getSeatName() {
            return seatName;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Reserved seat " + this.seatName);
                return true;
            }
            System.out.println("Seat " + this.seatName + " is booked");
            return false;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatName.compareToIgnoreCase(seat.getSeatName());
        }


    }
}
