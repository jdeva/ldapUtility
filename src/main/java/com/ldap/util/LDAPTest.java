package com.ldap.util;

import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.LdapContext;

public class LDAPTest {

    public static void main(String... args) throws NamingException {
        LDAPConnection con = new LDAPConnection();
        LdapContext ldapContext = con.getLdapContext();
        LDAPUtils helper = new LDAPUtils();
        SearchControls searchControls = helper.getSearchControls();
        helper.getUserInfo("email", ldapContext, searchControls);

    }
}
