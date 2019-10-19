import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[15][15];
        matrix[7][7] = 5;
        int playerRow = 7;
        int playerCol = 7;
        int playerHP = 18500;
        double heiganHP = 3000000;

        double damagePerTurn = Double.parseDouble(scanner.nextLine());

        boolean isCloud = false;
        boolean isEscaped = true;
        String lastSpell = "";

        while (playerHP > 0 && heiganHP > 0) {
            if (isCloud && !isEscaped) {
                playerHP -= 3500;
                isCloud = false;
            }

            heiganHP -= damagePerTurn;

            if (playerHP <= 0) {
                break;
            }
            if (heiganHP <= 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s");
            String spell = tokens[0];
            int power = 0;
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            List<Integer> damagedCells = findDamagedCells(matrix, row, col);
            boolean isAffected = false;
            for (int i = 0; i < damagedCells.size(); i += 2) {
                int currentRow = damagedCells.get(i);
                int currentCol = damagedCells.get(i + 1);
                if (currentRow == playerRow && currentCol == playerCol) {
                    isAffected = true;
                    break;
                }
            }
            if (isAffected) {
                switch (spell) {
                    case "Cloud":
                        power = 3500;
                        isCloud = true;
                        break;
                    case "Eruption":
                        power = 6000;
                        isCloud = false;
                        break;
                }
                boolean isAbleToMoveUp = checkUp(damagedCells, playerCol, playerRow);
                boolean isAbleToMoveRight = checkRight(damagedCells, playerCol, playerRow);
                boolean isAbleToMoveDown = checkDown(damagedCells, playerCol, playerRow);
                boolean isAbleToMoveLeft = checkLeft(damagedCells, playerCol, playerRow);

                if (isAbleToMoveUp) {
                    playerRow -= 1;
                    isEscaped = true;
                    lastSpell = spell;
                } else if (isAbleToMoveRight) {
                    playerCol += 1;
                    isEscaped = true;
                    lastSpell = spell;
                } else if (isAbleToMoveDown) {
                    playerRow += 1;
                    isEscaped = true;
                    lastSpell = spell;
                } else if (isAbleToMoveLeft) {
                    playerCol -= 1;
                    isEscaped = true;
                    lastSpell = spell;
                } else {
                    playerHP -= power;
                    lastSpell = spell;
                    isEscaped = false;
                }
            } else {
                lastSpell = spell;
            }
        }

        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f", heiganHP).println();
        }
        if (playerHP <= 0) {
            if (lastSpell.equals("Cloud")) {
                lastSpell = "Plague Cloud";
            }
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHP);
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);

    }

    private static boolean checkLeft(List<Integer> damagedCells, int playerCol, int playerRow) {
        boolean isAbleToMoveLeft = false;
        for (int i = 0; i < damagedCells.size(); i += 2) {
            int currentDamagedRow = damagedCells.get(i);
            int currentDamagedCol = damagedCells.get(i + 1);
            if (playerRow == currentDamagedRow && playerCol - 1 == currentDamagedCol) {
                isAbleToMoveLeft = false;
                break;
            } else {
                if (playerCol - 1 >= 0) {
                    isAbleToMoveLeft = true;
                }
            }
        }
        return isAbleToMoveLeft;
    }

    private static boolean checkRight(List<Integer> damagedCells, int playerCol, int playerRow) {
        boolean isAbleToMoveRight = false;
        for (int i = 0; i < damagedCells.size(); i += 2) {
            int currentDamagedRow = damagedCells.get(i);
            int currentDamagedCol = damagedCells.get(i + 1);
            if (playerRow == currentDamagedRow && playerCol + 1 == currentDamagedCol) {
                isAbleToMoveRight = false;
                break;
            } else {
                if (playerCol + 1 < 15) {
                    isAbleToMoveRight = true;
                }
            }
        }
        return isAbleToMoveRight;
    }

    private static boolean checkDown(List<Integer> damagedCells, int playerCol, int playerRow) {
        boolean isAbleToMoveDown = false;
        for (int i = 0; i < damagedCells.size(); i += 2) {
            int currentDamagedRow = damagedCells.get(i);
            int currentDamagedCol = damagedCells.get(i + 1);
            if (playerRow + 1 == currentDamagedRow && playerCol == currentDamagedCol) {
                isAbleToMoveDown = false;
                break;
            } else {
                if (playerRow + 1 < 15) {
                    isAbleToMoveDown = true;
                }
            }
        }
        return isAbleToMoveDown;
    }

    private static boolean checkUp(List<Integer> damagedCells, int playerCol, int playerRow) {
        boolean isAbleToMoveUp = false;
        for (int i = 0; i < damagedCells.size(); i += 2) {
            int currentDamagedRow = damagedCells.get(i);
            int currentDamagedCol = damagedCells.get(i + 1);
            if (playerRow - 1 == currentDamagedRow && playerCol == currentDamagedCol) {
                isAbleToMoveUp = false;
                break;
            } else {
                if (playerRow - 1 >= 0) {
                    isAbleToMoveUp = true;
                }
            }
        }
        return isAbleToMoveUp;
    }

    private static List<Integer> findDamagedCells(int[][] matrix, int row, int col) {
        List<Integer> damagedCells = new ArrayList<>();
        if (row < 15 && row >= 0 && col >= 0 && col < 15) {
            damagedCells.add(row);
            damagedCells.add(col);
        }
        if (row < 15 && row >= 0 && col + 1 >= 0 && col + 1 < 15) {
            damagedCells.add(row);
            damagedCells.add(col + 1);
        }
        if (row < 15 && row >= 0 && col - 1 >= 0 && col - 1 < 15) {
            damagedCells.add(row);
            damagedCells.add(col - 1);
        }
        if (row - 1 < 15 && row - 1 >= 0 && col >= 0 && col < 15) {
            damagedCells.add(row - 1);
            damagedCells.add(col);
        }
        if (row + 1 < 15 && row + 1 >= 0 && col >= 0 && col < 15) {
            damagedCells.add(row + 1);
            damagedCells.add(col);
        }

        if (row - 1 < 15 && row - 1 >= 0 && col - 1 >= 0 && col - 1 < 15) {
            damagedCells.add(row - 1);
            damagedCells.add(col - 1);
        }
        if (row - 1 < 15 && row - 1 >= 0 && col + 1 >= 0 && col + 1 < 15) {
            damagedCells.add(row - 1);
            damagedCells.add(col + 1);
        }

        if (row + 1 < 15 && row + 1 >= 0 && col - 1 >= 0 && col - 1 < 15) {
            damagedCells.add(row + 1);
            damagedCells.add(col - 1);
        }
        if (row + 1 < 15 && row + 1 >= 0 && col + 1 < 15 && col + 1 >= 0) {
            damagedCells.add(row + 1);
            damagedCells.add(col + 1);
        }


        return damagedCells;
    }

}
