package ru.whois.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DomainDTO {
    private DomainInfo domainInfo;
    private ContactInfo contactInfo;
    private List<HostInfo> hostInfo;
    private List<StatusInfo> statusInfo;
}