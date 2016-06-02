/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende and David RACODON
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
package org.sonar.css.checks;

import java.io.File;

import org.junit.Test;
import org.sonar.css.checks.verifier.CssCheckVerifier;

public class SelectorNamingConventionCheckTest {

  @Test
  public void test_with_default_format() {
    SelectorNamingConventionCheck check = new SelectorNamingConventionCheck();
    check.setFormat("^[a-z][-a-z0-9]*$");
    CssCheckVerifier.verify(check, new File("src/test/resources/checks/selectorNamingConvention.css"));
  }

  @Test
  public void test_with_custom_format() {
    SelectorNamingConventionCheck check = new SelectorNamingConventionCheck();
    check.setFormat("^[-a-z]+$");
    CssCheckVerifier.verify(check, new File("src/test/resources/checks/selectorNamingConventionCustomFormat.css"));
  }

}
