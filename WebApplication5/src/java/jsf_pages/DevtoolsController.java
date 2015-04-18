package jsf_pages;

import entities.Devtools;
import java.io.IOException;
import jsf_pages.util.JsfUtil;
import jsf_pages.util.PaginationHelper;
import session.DevtoolsFacade;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "devtoolsController")
@SessionScoped
public class DevtoolsController implements Serializable {

    private Devtools current;
    private DataModel items = null;
    @EJB
    private session.DevtoolsFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DevtoolsController() {
    }

    public Devtools getSelected() {
        if (current == null) {
            current = new Devtools();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public Devtools getSelected(int id) {
        if (current == null) {
            current = new Devtools(id);
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public void Preparesearch(String input, String type)
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        String[] lInput = input.split(" ");
        
        String params = "";
        
        for(String param:lInput)
        {
            params += param + "+";
        }
        
        params = params.substring(0, params.length()-1);
        
        try {
            context.redirect(context.getRequestContextPath() + "/devtools/search.xhtml?search=" + params + "&type=" + type);
        } catch (IOException ex) {
            Logger.getLogger(DevtoolsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Devtools> search()
    {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = params.get("search");
        String type = params.get("type");
        
        if(type == null)
        {
            return getFacade().findLike("");
        }
        
        if(type != "")
        {
            if(param == null)
            {
                return getFacade().findLikeWithType("",type);
            }

            return getFacade().findLikeWithType(param,type);
        }
        
        if(param == null)
         {
             return getFacade().findLike("");
         }

         return getFacade().findLike(param);
    }
    
    public void logout()
    {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
     
        try {
            context.redirect(context.getRequestContextPath() + "/devtools/search.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(DevtoolsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DevtoolsFacade getFacade() {
        return ejbFacade;
    }
    
    public void openComments(int id)
    {
        
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Devtools) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }
    
    public String prepareView(int id) {
        current = (Devtools) DevtoolsController.this.getSelected(id);
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Devtools();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DevtoolsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Devtools) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DevtoolsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Devtools) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DevtoolsDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }
    
    public List<Devtools> getItemsAvailable(int userId) {
        return ejbFacade.findOwn(userId);
    }
    
    public List<Devtools> all() {
        return ejbFacade.findAll();
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Devtools.class)
    public static class DevtoolsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DevtoolsController controller = (DevtoolsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "devtoolsController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Devtools) {
                Devtools o = (Devtools) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Devtools.class.getName());
            }
        }

    }

}
