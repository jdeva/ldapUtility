package com.ldap.util;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import javax.xml.registry.infomodel.User;

public class LDAPUtils {

    public void getUserInfo(String email, LdapContext ctx, SearchControls searchControls) {
        User user = null;
        boolean isActive = false;
        try {
            NamingEnumeration<SearchResult> answer = ctx.search("DC=some,DC=some,DC=some", "mail=" + email,
                    searchControls);
            if (answer.hasMore()) {
                Attributes attrs = ((SearchResult)answer.next()).getAttributes();
                String commonName = (String)attrs.get("cn").get();
                String givenName = (String)attrs.get("cn").get();
                System.out.println("email: "+email+ " cn: "+commonName+" givenname: "+givenName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public SearchControls getSearchControls() {
        SearchControls cons = new SearchControls();
        cons.setSearchScope(2);
        String[] attrIDs = { "cn", "givenname",  "mail"};
        cons.setReturningAttributes(attrIDs);
        return cons;
    }
}
