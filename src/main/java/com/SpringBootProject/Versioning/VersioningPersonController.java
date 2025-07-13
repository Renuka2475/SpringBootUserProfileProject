package com.SpringBootProject.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController
{

    @GetMapping("/person/v1")
    public Personv1 getPersonV1Name (){
        return  new Personv1("Reddy Renuka");
    }

    @GetMapping("/person/v2")
    public Personv2 getPersonV2Name(){
        return new Personv2("Reddy","Renuka");

    }

    @GetMapping(path="/person", params="version=1")
    public Personv1 getPersonV1NameRequestparam (){
        return  new Personv1("Reddy Renuka");
    }

    @GetMapping(path="/person", params="version=2")
    public Personv2 getPersonV2NameRequestParam(){
        return new Personv2("Reddy","Renuka");

    }

    @GetMapping(path="/person/header", headers="X-API-VERSION=1")
    public Personv1 getPersonV1NameRequestparamRequestHeader  (){
        return  new Personv1("Reddy Renuka");
    }

    @GetMapping(path="/person/header", headers="X-API-VERSION=2")
    public Personv2 getPersonV2NameRequestParamRequestHeader(){
        return new Personv2("Reddy","Renuka");

    }

    @GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json")
    public Personv1 getPersonV1NameRequestparamAccept(){
        return  new Personv1("Reddy Renuka");
    }

    @GetMapping(path="/person/accept", produces="application/vnd.company.app-v2+json")
    public Personv2 getPersonV2NameRequestParamRequestAccept(){
        return new Personv2("Reddy","Renuka");

    }


}
