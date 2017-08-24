// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.components.jdbc.wizard;

import org.talend.components.api.wizard.ComponentWizard;
import org.talend.components.api.wizard.ComponentWizardDefinition;

public class JDBCRetrieveSchemaWizard extends ComponentWizard {

    JDBCConnectionWizardProperties connectionProperties;

    JDBCRetrieveSchemaWizardProperties retrieveSchemaProperties;

    JDBCRetrieveSchemaWizard(ComponentWizardDefinition def, String repositoryLocation) {
        super(def, repositoryLocation);

        connectionProperties = new JDBCConnectionWizardProperties("connection").setRepositoryLocation(repositoryLocation);
        connectionProperties.init();

        retrieveSchemaProperties = new JDBCRetrieveSchemaWizardProperties("retrieveschema")
                .setConnection(connectionProperties).setRepositoryLocation(repositoryLocation);
        retrieveSchemaProperties.init();

        addForm(retrieveSchemaProperties.getForm(JDBCRetrieveSchemaWizardProperties.FORM_PAGE1));
        addForm(retrieveSchemaProperties.getForm(JDBCRetrieveSchemaWizardProperties.FORM_PAGE2));
//        addForm(retrieveSchemaProperties.getForm(JDBCRetrieveSchemaWizardProperties.FORM_PAGE3));
    }

    public void setupProperties(JDBCConnectionWizardProperties connectionProperties) {
        this.connectionProperties.copyValuesFrom(connectionProperties);
        this.retrieveSchemaProperties.setConnection(this.connectionProperties);
    }

}
