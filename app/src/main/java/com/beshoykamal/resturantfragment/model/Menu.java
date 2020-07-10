
package com.beshoykamal.resturantfragment.model;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class Menu
{
    private Date created;
    private String Items;
    private String ownerId;
//
//    public Menu(Date created, String items, String ownerId, Date updated, String URL, String price, String name, String objectId) {
//        this.created = created;
//        Items = items;
//        this.ownerId = ownerId;
//        this.updated = updated;
//        this.URL = URL;
//        Price = price;
//        Name = name;
//        this.objectId = objectId;
//    }

    private Date updated;
    private String URL;
    private String Price;
    private String Name;
    private String objectId;

    public Menu(){}

  public Date getCreated()
  {
    return created;
  }

  public String getItems()
  {
    return Items;
  }

  public void setItems( String Items )
  {
    this.Items = Items;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getURL()
  {
    return URL;
  }

  public void setURL( String URL )
  {
    this.URL = URL;
  }

  public String getPrice()
  {
    return Price;
  }

  public void setPrice( String Price )
  {
    this.Price = Price;
  }

  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

  public String getObjectId()
  {
    return objectId;
  }

                                                    
  public Menu save()
  {
    return Backendless.Data.of( Menu.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Menu.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Menu.class ).remove( this, callback );
  }

  public static Menu findById( String id )
  {
    return Backendless.Data.of( Menu.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findById( id, callback );
  }

  public static Menu findFirst()
  {
    return Backendless.Data.of( Menu.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findFirst( callback );
  }

  public static Menu findLast()
  {
    return Backendless.Data.of( Menu.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Menu> callback )
  {
    Backendless.Data.of( Menu.class ).findLast( callback );
  }

  public static List<Menu> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Menu.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Menu>> callback )
  {
    Backendless.Data.of( Menu.class ).find( queryBuilder, callback );
  }
}
