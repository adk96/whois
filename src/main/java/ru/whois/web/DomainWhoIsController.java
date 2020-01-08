package ru.whois.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.whois.model.*;
import ru.whois.repository.ContactsRepository;
import ru.whois.repository.DomainRepository;
import ru.whois.repository.HostRepository;
import ru.whois.repository.StatusRepository;

import java.util.List;

@RestController
@RequestMapping("api/whois")
public class DomainWhoIsController {

    @Autowired
    DomainRepository domainRepository;

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    HostRepository hostRepository;

    @Autowired
    StatusRepository statusRepository;

    @PostMapping
    public DomainDTO whoIs(@RequestBody Request request) {
        System.out.println(request);
        DomainInfo domainInfo = domainRepository.findDomainInfo(request.getDomain());
        ContactInfo contactInfo = contactsRepository.findContactInfo(request.getDomain());
        List<HostInfo> hostInfo = hostRepository.findHostInfo(request.getDomain());
        List<StatusInfo> statusInfo = statusRepository.findStatusInfo(request.getDomain());

        return new DomainDTO(domainInfo, contactInfo, hostInfo, statusInfo);
    }

    /*@GetMapping("/{name}")
    public DomainDTO domainDTO(@PathVariable("name") String domain) {
        DomainInfo domainInfo = domainRepository.findDomainInfo(domain);
        ContactInfo contactInfo = contactsRepository.findContactInfo(domain);
        List<HostInfo> hostInfo = hostRepository.findHostInfo(domain);
        List<StatusInfo> statusInfo = statusRepository.findStatusInfo(domain);

        return new DomainDTO(domainInfo, contactInfo, hostInfo, statusInfo);
    }*/
}
