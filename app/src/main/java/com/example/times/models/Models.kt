package com.ny.times

class HomeFeed(val results: List<News>)

class News(
    val uri: String,
    val url: String,
    val id: String,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val adx_keywords: String,
    val column: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val eta_id: Int,
    val media_file: Media,
    val des_fa: Facet,
    val org_fa: FacetOrg,
    val per_fa: FacetPer,
    val geo_fa: FacetGeo

)

class FacetGeo(val geo_facet: List<String>)
class FacetPer(val per_facet: List<String>)
class FacetOrg(val org_facet: List<String>)
class Facet(val des_facet: List<String>)
class Media(val media: List<MedialItem>)

class MedialItem(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approved_for_syndication: Int,
    val media_metadata: MetaData

)

class MetaData(val media_metadata: List<MetaDataItem>)

class MetaDataItem(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approved_for_syndication: Int

)