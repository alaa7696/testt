package com.sqli;

import java.util.ArrayList;
import java.util.List;

public class Gossips {
    int index=0;
    String currentSay;

    List<Personne> persons;
    List<String> senders;
    String[] names;

    public Gossips(String... names) {

        persons =new ArrayList();
        senders=new ArrayList<String>();
        this.names=names;
        //System.out.println(Arrays.toString(names));
    }

    public Gossips from(String name) {
        for(int i=0;i<names.length;i++) {
            String temp=names[i].split(" ")[1];
            if (temp.equals(name))
                name=names[i];
        }
        return new GossipsBuilder(this, name).from();
    }

    public Gossips to(String name) {
        if(currentSay!=null){
            System.out.println("ouiiiiiiiiiiiiiiiiiii");
            Personne personne= findPersonne(persons,name);
            personne.setSay(currentSay);
        }
        else {
            for(int i=0;i<names.length;i++) {
                String temp=names[i].split(" ")[1];
                if (temp.equals(name))
                    name=names[i];
            }
            return new GossipsBuilder(this, name).to();
        }
        return this;
    }


    public Gossips say(String say) {
        this.currentSay=say;
        return this;
    }



    public String ask(String name) {
        Personne personne= findPersonne(persons,name);
        return personne.ask();
    }


    public Personne findPersonne(List<Personne> mistersFrom, String name) {
        for(Personne m:mistersFrom)
            if (m.getName().equals(name))
                return m;
        return null;
    }

    public void spread() {
        String senderName=senders.get(index);
        Personne personne= findPersonne(persons,senderName);
        Personne rec= findPersonne(persons,personne.getReceptor());
        for(Personne personne1:persons)
            System.out.print(personne1.getName()+" ");
        System.out.println(personne.getName());
        System.out.println(rec.getName());
        rec.setSay(personne.getSay());
        if(personne.getType().equals("Mr"))
        personne.setSay("");

        index++;
    }
}
