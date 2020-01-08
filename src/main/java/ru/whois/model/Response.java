package ru.whois.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response {
    private DomainInfo domainInfo;
    private ContactInfo contactInfo;
    private List<HostInfo> hostInfo;
    private List<StatusInfo> statusInfo;
}
