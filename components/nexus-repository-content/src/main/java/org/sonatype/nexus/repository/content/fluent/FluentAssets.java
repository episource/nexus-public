/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.content.fluent;

import java.util.Optional;

import javax.annotation.Nullable;

import org.sonatype.nexus.common.entity.Continuation;
import org.sonatype.nexus.common.entity.EntityId;
import org.sonatype.nexus.repository.content.Asset;

/**
 * Fluent API for assets.
 *
 * @since 3.21
 */
public interface FluentAssets
{
  /**
   * Start building an asset, beginning with its path.
   */
  FluentAssetBuilder path(String path);

  /**
   * Interact with an existing asset.
   */
  FluentAsset with(Asset asset);

  /**
   * Count all assets in the repository.
   */
  int count();

  /**
   * Browse through all assets in the repository.
   */
  default Continuation<FluentAsset> browse(int limit, @Nullable String continuationToken) {
    return browse(null, limit, continuationToken);
  }

  /**
   * Browse through all assets in the repository by kind.
   */
  Continuation<FluentAsset> browse(@Nullable String kind, int limit, @Nullable String continuationToken);

  /**
   * Find if an asset exists that has the given external id.
   *
   * @since 3.next
   */
  Optional<FluentAsset> find(EntityId externalId);
}
