package models.clubs;

import enums.Gender;
import models.archers.Archer;

import java.util.*;
import java.util.stream.Collectors;

public class ArcherClub {
    private String name;
    private String address;
    private String trainer;
    private List<Archer> archers;
    private Map<Archer, Integer> juniorResults;
    private Map<Archer, Integer> seniorResults;
    private Map<Archer, Integer> veteranResults;

    public ArcherClub(String name, String address, String trainer) {
        this.name = name;
        this.address = address;
        this.trainer = trainer;
        this.archers = new ArrayList<>();
        this.juniorResults = new LinkedHashMap<>();
        this.seniorResults = new LinkedHashMap<>();
        this.veteranResults = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getTrainer() {
        return this.trainer;
    }

    public List<Archer> getArchers() {
        return this.archers;
    }

    public void addArcher(Archer archer) {
        this.archers.add(archer);
    }

    public String startTournament() {
        distributeArchers();
        StringBuilder sb = new StringBuilder();
        sb.append(this.getStatistics());
        sb.append(this.getWinners());
        sb.append(this.getAverageScores());
        sb.append(this.getTheBestShooter());
        sb.append(this.getTheWorstShooter());
        sb.append(this.getFemaleStatistics());
        sb.append(this.getMaleWithCarbonBowsStatistics());

        return sb.toString().trim();
    }

    private String getMaleWithCarbonBowsStatistics() {
        StringBuilder sb = new StringBuilder();
        Map<Archer, Integer> maleSeniorArchers = this.seniorResults.entrySet().stream().filter(entry -> entry.getKey().getGender().toString().equals(Gender.MALE.toString())).filter(entry -> entry.getKey().getBow().getClass().getSimpleName().contains("Carbon")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Archer, Integer> maleVeteranArchers = this.veteranResults.entrySet().stream().filter(entry -> entry.getKey().getGender().toString().equals(Gender.MALE.toString())).filter(entry -> entry.getKey().getBow().getClass().getSimpleName().contains("Carbon")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        sb.append("Archers with carbon bows by experience:").append(System.lineSeparator());

        maleVeteranArchers.entrySet().stream().sorted((f, s) -> s.getKey().getExperience() - f.getKey().getExperience()).forEach(entry -> {
            String name = entry.getKey().getName();
            int experience = entry.getKey().getExperience();
            sb.append(String.format("  * %s with experience: %d years", name, experience)).append(System.lineSeparator());
        });
        maleSeniorArchers.entrySet().stream().sorted((f, s) -> s.getKey().getExperience() - f.getKey().getExperience()).forEach(entry -> {
            String name = entry.getKey().getName();
            int experience = entry.getKey().getExperience();
            sb.append(String.format("  * %s with experience: %d years", name, experience)).append(System.lineSeparator());
        });
        return sb.toString();

    }

    private String getFemaleStatistics() {
        StringBuilder sb = new StringBuilder();
        Map<Archer, Integer> femaleJuniorArchers = this.juniorResults.entrySet().stream().filter(entry -> entry.getKey().getGender().toString().equals(Gender.FEMALE.toString())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Archer, Integer> femaleSeniorArchers = this.seniorResults.entrySet().stream().filter(entry -> entry.getKey().getGender().toString().equals(Gender.FEMALE.toString())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Archer, Integer> femaleVeteranArchers = this.veteranResults.entrySet().stream().filter(entry -> entry.getKey().getGender().toString().equals(Gender.FEMALE.toString())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map.Entry<Archer, Integer> juniorBestArcher = this.juniorResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).findFirst().orElse(null);
        int maxJuniorPoints = juniorBestArcher.getValue();
        Map.Entry<Archer, Integer> seniorBestArcher = this.seniorResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).findFirst().orElse(null);
        int maxSeniorPoints = seniorBestArcher.getValue();
        Map.Entry<Archer, Integer> veteranBestArcher = this.veteranResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).findFirst().orElse(null);
        int maxVeteranPoints = veteranBestArcher.getValue();
        sb.append("Junior female archers:").append(System.lineSeparator());
        femaleJuniorArchers.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            double points = entry.getValue();
            double percentage = points / maxJuniorPoints * 100.0;
            sb.append(String.format("  * %s : %.2f%%", name, percentage)).append(System.lineSeparator());
        });
        sb.append("Senior female archers:").append(System.lineSeparator());
        femaleSeniorArchers.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            double points = entry.getValue();
            double percentage = points / maxSeniorPoints * 100.0;
            sb.append(String.format("  * %s : %.2f%%", name, percentage)).append(System.lineSeparator());
        });
        sb.append("Veteran female archers:").append(System.lineSeparator());
        femaleVeteranArchers.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            double points = entry.getValue();
            double percentage = points / maxVeteranPoints * 100.0;
            sb.append(String.format("  * %s : %.2f%%", name, percentage)).append(System.lineSeparator());
        });
        return sb.toString();

    }

    private String getTheWorstShooter() {
        StringBuilder sb = new StringBuilder();
        List<Archer> worstArchers = this.archers.stream().sorted((f, s) -> s.getMissedShots() - f.getMissedShots()).collect(Collectors.toList());
        Archer archer = worstArchers.get(0);
        sb.append(String.format("Worst shooter: %s with missed shots: %d", archer.getName(), archer.getMissedShots())).append(System.lineSeparator());
        return sb.toString();
    }

    private String getTheBestShooter() {
        StringBuilder sb = new StringBuilder();
        List<Archer> bestArchers = this.archers.stream().sorted((f, s) -> s.getMaxPointHits() - f.getMaxPointHits()).collect(Collectors.toList());
        Archer archer = bestArchers.get(0);
        sb.append(String.format("Best shooter: %s with maxpoint shots: %d", archer.getName(), archer.getMaxPointHits())).append(System.lineSeparator());
        return sb.toString();
    }

    private String getAverageScores() {
        StringBuilder sb = new StringBuilder();
        double juniorAverage = this.juniorResults.values().stream().mapToInt(a -> a).average().getAsDouble();
        double seniorAverage = this.seniorResults.values().stream().mapToInt(a -> a).average().getAsDouble();
        double veteranAverage = this.veteranResults.values().stream().mapToInt(a -> a).average().getAsDouble();
        sb.append(String.format("Junior average score: %.0f", juniorAverage)).append(System.lineSeparator());
        sb.append(String.format("Senior average score: %.0f", seniorAverage)).append(System.lineSeparator());
        sb.append(String.format("Veteran average score: %.0f", veteranAverage)).append(System.lineSeparator());
        return sb.toString();
    }

    private void distributeArchers() {
        List<Archer> participants = this.archers.stream().sorted(Comparator.comparing(Archer::getName)).collect(Collectors.toList());
        participants.forEach(Archer::participate);
        participants.forEach(p -> {
            Archer archer = p;
            int points = archer.shoot();
            if (p.getClass().getSimpleName().contains("Junior")) {
                this.juniorResults.put(archer, points);
            } else if (p.getClass().getSimpleName().contains("Senior")) {
                this.seniorResults.put(archer, points);
            } else {
                this.veteranResults.put(archer, points);
            }
        });
    }

    private String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Junior:").append(System.lineSeparator());
        this.juniorResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            int points = entry.getValue();
            sb.append(String.format("  * %s : %d", name, points)).append(System.lineSeparator());
        });
        sb.append("Senior:").append(System.lineSeparator());
        this.seniorResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            int points = entry.getValue();
            sb.append(String.format("  * %s : %d", name, points)).append(System.lineSeparator());
        });
        sb.append("Veteran:").append(System.lineSeparator());
        this.veteranResults.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).forEach(entry -> {
            String name = entry.getKey().getName();
            int points = entry.getValue();
            sb.append(String.format("  * %s : %d", name, points)).append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    private String getWinners() {
        StringBuilder sb = new StringBuilder().append(System.lineSeparator());
        sb.append("Junior winner: ");

        sb.append(getWinner(this.juniorResults)).append(System.lineSeparator());
        sb.append("Senior winner: ");
        sb.append(getWinner(this.seniorResults)).append(System.lineSeparator());
        sb.append("Veteran winner: ");
        sb.append(getWinner(this.veteranResults)).append(System.lineSeparator());


        return sb.toString();
    }

    private String getWinner(Map<Archer, Integer> results) {
        Map.Entry<Archer, Integer> winner = results.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).findFirst().orElse(null);
        return String.format("%s, Points: %d", winner.getKey().getName(), winner.getValue());
    }
}
