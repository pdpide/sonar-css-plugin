/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende
 * kende.tamas@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.css.checks.validators;

import com.google.common.collect.ImmutableList;
import com.sonar.sslr.api.AstNode;

import javax.annotation.Nonnull;

public class PropertyValueMultiValidator implements PropertyValueValidator {

  private final ImmutableList<PropertyValueValidator> validators;

  public PropertyValueMultiValidator(@Nonnull ImmutableList<PropertyValueValidator> validators) {
    this.validators = validators;
  }

  @Override
  public boolean isPropertyValueValid(@Nonnull AstNode valueAstNode) {
    for (PropertyValueValidator validator : validators) {
      if (validator.isPropertyValueValid(valueAstNode)) {
        return true;
      }
    }
    return false;
  }

  @Override
  @Nonnull
  public String getValidatorFormat() {
    StringBuilder format = new StringBuilder();
    for (PropertyValueValidator validator : validators) {
      if (format.length() > 0) {
        format.append(" | ");
      }
      format.append(validator.getValidatorFormat());
    }
    return format.toString();
  }

}