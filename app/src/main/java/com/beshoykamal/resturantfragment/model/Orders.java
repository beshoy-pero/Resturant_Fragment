
package com.beshoykamal.resturantfragment.model;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class Orders
{
  private String name;
  private String objectId;
  private Date updated;
  private String kinds;
  private String phone;
  private Date created;
  private String amount;
  private String ownerId;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getKinds()
  {
    return kinds;
  }

  public void setKinds( String kinds )
  {
    this.kinds = kinds;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone( String phone )
  {
    this.phone = phone;
  }

  public Date getCreated()
  {
    return created;
  }

  public String getAmount()
  {
    return amount;
  }

  public void setAmount( String amount )
  {
    this.amount = amount;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public Orders save()
  {
    return Backendless.Data.of( Orders.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Orders> callback )
  {
    Backendless.Data.of( Orders.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Orders.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Orders.class ).remove( this, callback );
  }

  public static Orders findById(String id )
  {
    return Backendless.Data.of( Orders.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Orders> callback )
  {
    Backendless.Data.of( Orders.class ).findById( id, callback );
  }

  public static Orders findFirst()
  {
    return Backendless.Data.of( Orders.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Orders> callback )
  {
    Backendless.Data.of( Orders.class ).findFirst( callback );
  }

  public static Orders findLast()
  {
    return Backendless.Data.of( Orders.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Orders> callback )
  {
    Backendless.Data.of( Orders.class ).findLast( callback );
  }

  public static List<Orders> find(DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Orders.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Orders>> callback )
  {
    Backendless.Data.of( Orders.class ).find( queryBuilder, callback );
  }
}