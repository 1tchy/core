/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.webbeans.bean;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.webbeans.Dependent;
import javax.webbeans.Standard;

import org.jboss.webbeans.ManagerImpl;
import org.jboss.webbeans.introspector.AnnotatedClass;
import org.jboss.webbeans.introspector.jlr.AnnotatedClassImpl;
import org.jboss.webbeans.literal.NewLiteral;

/**
 * Represents a @New enterprise bean
 * 
 * @author Nicklas Karlsson
 */
public class NewEnterpriseBean<T> extends EnterpriseBean<T>
{
   private static Set<Annotation> NEW_BINDING_SET = new HashSet<Annotation>(Arrays.asList(new NewLiteral()));

   /**
    * Creates an instance of a NewEnterpriseBean from an annotated class
    * 
    * @param clazz The annotated class
    * @param manager The Web Beans manager
    * @return a new NewEnterpriseBean instance
    */
   public static <T> NewEnterpriseBean<T> of(AnnotatedClass<T> clazz, ManagerImpl manager)
   {
      return new NewEnterpriseBean<T>(clazz, manager);
   }

   /**
    * Creates an instance of a NewEnterpriseBean from a class
    * 
    * @param clazz The class
    * @param manager The Web Beans manager
    * @return a new NewEnterpriseBean instance
    */
   public static <T> NewEnterpriseBean<T> of(Class<T> clazz, ManagerImpl manager)
   {
      return of(AnnotatedClassImpl.of(clazz), manager);
   }

   /**
    * Protected constructor
    * 
    * @param type An annotated class
    * @param manager The Web Beans manager
    */
   protected NewEnterpriseBean(AnnotatedClass<T> type, ManagerImpl manager)
   {
      super(type, manager);
   }

   /**
    * Gets the scope type
    * 
    * @return @Dependent
    */
   @Override
   public Class<? extends Annotation> getScopeType()
   {
      return Dependent.class;
   }

   /**
    * Gets the deployment type
    * 
    * @return The standard deployment type
    */
   @Override
   public Class<? extends Annotation> getDeploymentType()
   {
      return Standard.class;
   }

   /**
    * Gets the name of the bean
    * 
    * @return null
    */
   @Override
   public String getName()
   {
      return null;
   }

   /**
    * Gets the bindings
    * 
    * @returns @New
    */
   @Override
   public Set<Annotation> getBindings()
   {
      return NEW_BINDING_SET;
   }
   
   @Override
   public boolean isSpecializing()
   {
      return false;
   }

}
