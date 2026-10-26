package com.floodwatch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.floodwatch.entity.FloodReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FloodReportResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("latitude")
    private Double latitude;  // Changed to Double for JSON compatibility

    @JsonProperty("longitude")
    private Double longitude;  // Changed to Double for JSON compatibility

    @JsonProperty("severity")
    private String severity;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("location")
    private String location;

    @JsonProperty("status")
    private String status;

    @JsonProperty("reportedBy")
    private String reportedBy;

    @JsonProperty("verifiedBy")
    private String verifiedBy;

    @JsonProperty("verifiedAt")
    private LocalDateTime verifiedAt;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("resolvedAt")
    private LocalDateTime resolvedAt;

    // Public constructor for Jackson
    public FloodReportResponse() {
    }

    // Constructor from entity
    public FloodReportResponse(FloodReport report) {
        this.id = report.getId();
        // Convert BigDecimal to Double for JSON compatibility
        this.latitude = report.getLatitude() != null ? report.getLatitude().doubleValue() : null;
        this.longitude = report.getLongitude() != null ? report.getLongitude().doubleValue() : null;
        this.location = report.getLocation();
        this.description = report.getDescription();
        this.imageUrl = report.getImageUrl();
        this.severity = report.getSeverity() != null ? report.getSeverity().name() : null;
        this.status = report.getStatus() != null ? report.getStatus().name() : null;
        this.reportedBy = report.getReportedBy() != null ? report.getReportedBy().getFullName() : null;
        this.verifiedBy = report.getVerifiedBy() != null ? report.getVerifiedBy().getFullName() : null;
        this.verifiedAt = report.getVerifiedAt();
        this.createdAt = report.getCreatedAt();
        this.resolvedAt = report.getResolvedAt();
    }

    // Static factory method (optional alternative)
    public static FloodReportResponse fromEntity(FloodReport report) {
        return new FloodReportResponse(report);
    }

    // Getters (required for JSON serialization)
    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    // Setters (required for Jackson deserialization)
    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    @Override
    public String toString() {
        return "FloodReportResponse{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", severity='" + severity + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}