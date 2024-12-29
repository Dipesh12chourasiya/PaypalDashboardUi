package com.example.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactAdapter(
    private val contactList: ArrayList<ContactDomain>
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // ViewHolder class to hold reference to the views
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
    }

    // Inflating the layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    // Binding data to the views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.titleText.text = contact.name

        // Resolve the drawable resource ID from the picAddress
        val resourceId = holder.itemView.context.resources.getIdentifier(
            contact.picAddress, // Name of the drawable resource (e.g., "user_1")
            "drawable",         // Resource type
            holder.itemView.context.packageName // Package name
        )

        // Using Glide for loading images
        Glide.with(holder.itemView.context)
            .load(resourceId) // Load the resolved resource ID
            .placeholder(R.drawable.user_1) // Placeholder image in case of loading failure
            .into(holder.pic)
    }


    // Returning the size of the list
    override fun getItemCount(): Int {
        return contactList.size
    }
}
