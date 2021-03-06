/*
 * Copyright 2013 Decebal Suiu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with
 * the License. You may obtain a copy of the License in the LICENSE file, or at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package ro.fortsoft.wicket.dashboard.widget.ofchart;

import org.apache.wicket.Application;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

import ro.fortsoft.wicket.dashboard.Dashboard;
import ro.fortsoft.wicket.dashboard.DashboardContextInitializer;
import ro.fortsoft.wicket.dashboard.web.DashboardContext;

/**
 * @author Decebal Suiu
 */
public class DataResourceReference extends ResourceReference {

	private static final long serialVersionUID = 1L;

	public DataResourceReference() {
		super(OpenFlashChart.class, "wicket-ofc-data");
	}

	@Override
	public IResource getResource() {
		return new DataResource(getDashboard());
	}
	
	// TODO
	private Dashboard getDashboard() {
		DashboardContext dashboardContext = Application.get().getMetaData(DashboardContextInitializer.DASHBOARD_CONTEXT_KEY);
		Dashboard dashboard = dashboardContext.getDashboardPersiter().load();
		
		return dashboard;
	}

}
