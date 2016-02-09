<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
<?xml version="1.0" encoding="UTF-8"?>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">



    <!-- Header -->
    <ui:define name="title">Users Page</ui:define>

    <!-- Content -->
    <ui:define name="content">
        <h:form id="form">
            <p:growl id="msgs" showDetail="true"/>

            <!-- Users Table -->
            <p:dataTable id="usersTable" var="user" value="#{users.users}">
                <f:facet name="header">Users</f:facet>
                <p:column headerText="ID">#{user.id}</p:column>
                <p:column headerText="Name">#{user.name}</p:column>
                <p:column headerText="Surname">#{user.surname}</p:column>
                <p:column headerText="Edit" styleClass="centered">
                    <p:button value="Edit"
                              outcome="edit-user"
                              includeViewParams="true"
                              update="usersTable"
                              icon="fa fa-edit">
                        <f:param name="userId" value="#{user.id}"/>
                    </p:button>
                </p:column>
                <p:column headerText="Delete" styleClass="centered">
                    <p:commandButton
                            value="Delete"
                            action="#{users.deleteUser(user)}"
                            update="usersTable"
                            icon="fa fa-remove"/>
                </p:column>
            </p:dataTable>

            <!-- Create User Button -->
            <p:button value="Create User"
                      outcome="create-user"
                      styleClass="create-user-btn"
                      icon="fa fa-user"/>
        </h:form>
    </ui:define>
</ui:composition>

</html>
