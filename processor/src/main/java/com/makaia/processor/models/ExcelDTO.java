package com.makaia.processor.models;

public class ExcelDTO {
    private double date;
    private String injuryLocation;
    private String gender;
    private String ageGroup;
    private String incidentType;
    private double daysLost;
    private String plant;
    private String reportType;
    private String shift;
    private String department;
    private double incidentCost;
    private String wkDay;
    private double month;
    private double year;

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public String getInjuryLocation() {
        return injuryLocation;
    }

    public void setInjuryLocation(String injuryLocation) {
        this.injuryLocation = injuryLocation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public double getDaysLost() {
        return daysLost;
    }

    public void setDaysLost(double daysLost) {
        this.daysLost = daysLost;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getIncidentCost() {
        return incidentCost;
    }

    public void setIncidentCost(double incidentCost) {
        this.incidentCost = incidentCost;
    }

    public String getWkDay() {
        return wkDay;
    }

    public void setWkDay(String wkDay) {
        this.wkDay = wkDay;
    }

    public double getMonth() {
        return month;
    }

    public void setMonth(double month) {
        this.month = month;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }
}
