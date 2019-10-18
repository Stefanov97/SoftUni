public class Clinic {
    private String name;
    private int rooms;
    private Pet[] clinicRooms;

    public Clinic(String name, int rooms) throws IllegalAccessException {
        this.name = name;

        if (rooms % 2 == 0) {
            throw new IllegalAccessException("Invalid Operation!");
        } else {
            this.rooms = rooms;
        }
        this.clinicRooms = new Pet[rooms];
    }
    public String getName() {
        return name;
    }

    public boolean add(Pet pet) {
        if (hasEmptyRooms()) {
            int centerRoomIndex = ((this.rooms + 1) / 2) - 1;
            int elementsFromLeftAndRight = (this.rooms - 1) / 2;
            for (int i = 0; i <= elementsFromLeftAndRight; i++) {
                if (this.clinicRooms[centerRoomIndex - i] == null) {
                    this.clinicRooms[centerRoomIndex - i] = pet;
                    break;
                } else if (this.clinicRooms[centerRoomIndex + i] == null) {
                    this.clinicRooms[centerRoomIndex + i] = pet;
                    break;
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public boolean Release() {
        int centerRoomIndex = ((this.rooms + 1) / 2) - 1;
        for (int i = centerRoomIndex; i < this.clinicRooms.length; i++) {
            if (this.clinicRooms[i] != null) {
                this.clinicRooms[i] = null;
                return true;
            }

        }
        for (int i = 0; i < centerRoomIndex; i++) {
            if (this.clinicRooms[i] != null) {
                this.clinicRooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        boolean has = false;
        for (Pet clinicRoom : this.clinicRooms) {
            if (clinicRoom == null) {
                has = true;
                break;
            }
        }
        return has;
    }

    public void Print() {
        for (Pet clinicRoom : this.clinicRooms) {
            if (clinicRoom == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(clinicRoom);
            }
        }
    }

    public void Print(int indexOfRoom) {
        if (clinicRooms[indexOfRoom] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(clinicRooms[indexOfRoom]);
        }
    }
}


